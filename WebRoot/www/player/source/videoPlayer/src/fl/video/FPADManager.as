// Copyright � 2004-2007. Adobe Systems Incorporated. All Rights Reserved.
package fl.video {

	import flash.net.URLLoader;
	import flash.net.URLRequest;
	import flash.events.*;

	use namespace flvplayback_internal;

	/**
	 * <p>Handles downloading and parsing fpad xml format for
	 * fl.video.NCManager.  This xml format is generated by FMS 2.0.</p>
	 * 
     * @private
     *
     * @langversion 3.0
     * @playerversion Flash 9.0.28.0
	 */

	public class FPADManager {

		include "ComponentVersion.as"

		// INCManager to ping when done
		private var _owner:INCManager;

		// fpad support
		flvplayback_internal var xml:XML;
		flvplayback_internal var xmlLoader:URLLoader;
		flvplayback_internal var rtmpURL:String;

		flvplayback_internal var _url:String;
		flvplayback_internal var _uriParam:String;
		flvplayback_internal var _parseResults:ParseResults;

		/**
         * constructor
         *
         * @langversion 3.0
         * @playerversion Flash 9.0.28.0
		 */
		public function FPADManager(owner:INCManager) {
			_owner = owner;
		} 

		/**
		 * <p>Starts download of XML file.  Will be parsed and based
		 * on that we will decide how to connect.</p>
		 *
         * @private
         *
         * @langversion 3.0
         * @playerversion Flash 9.0.28.0
		 */
		flvplayback_internal function connectXML( urlPrefix:String, uriParam:String, urlSuffix:String,
		                                          uriParamParseResults:ParseResults ):Boolean {
			// init instance vars
			_uriParam = uriParam;
			_parseResults = uriParamParseResults;

			// put URL together
			_url = urlPrefix + "uri=" + _parseResults.protocol;
			if (_parseResults.serverName != null) {
				_url += "/" + _parseResults.serverName;
			}
			if (_parseResults.portNumber != null) {
				_url += ":" + _parseResults.portNumber;
			}
			if (_parseResults.wrappedURL != null) {
				_url += "/?" + _parseResults.wrappedURL;
			}
			_url += "/" + _parseResults.appName;
			_url += urlSuffix;
			//ifdef DEBUG
			//NCManager(_owner).debugTrace("FPAD download xml url: " + _url);
			//endif

			xml = new XML();
			xmlLoader = new URLLoader();
			xmlLoader.addEventListener(Event.COMPLETE, xmlLoadEventHandler);
			xmlLoader.addEventListener(IOErrorEvent.IO_ERROR, xmlLoadEventHandler);
			xmlLoader.addEventListener(SecurityErrorEvent.SECURITY_ERROR, xmlLoadEventHandler);
			xmlLoader.load(new URLRequest(_url));
			return false;
		}

		/**
		 * <p>Handles load of XML.
		 *
         * @private
         *
         * @langversion 3.0
         * @playerversion Flash 9.0.28.0
		 */
		flvplayback_internal function xmlLoadEventHandler(e:Event):void {
			try {
				if (e.type != Event.COMPLETE) {
					// todo: handle security and io errors differently?
					// signal failure
					_owner.helperDone(this, false);
				} else {
					xml = new XML(xmlLoader.data);
					if (xml == null || xml.localName() == null) {
						throw new VideoError(VideoError.INVALID_XML, "URL: \"" + _url + "\" No root node found; if url is for an flv it must have .flv extension and take no parameters");
					} else if (xml.localName() != "fpad") {
						throw new VideoError(VideoError.INVALID_XML, "URL: \"" + _url + "\" Root node not fpad");
					}

					// extract proxy info
					var proxy:String = null;
					if ( xml.proxy.length() > 0 &&
					     xml.proxy.hasSimpleContent() &&
					     xml.proxy.*[0].nodeKind() == "text" ) {
						proxy = xml.proxy.*[0].toString();
					}
					if (proxy == null) {	
						throw new VideoError(VideoError.INVALID_XML, "URL: \"" + _url + "\" fpad xml requires proxy tag.");
					}

					// assemble new uri
					rtmpURL = _parseResults.protocol + "/" + proxy + "/?" + _uriParam;

					//ifdef DEBUG
					//NCManager(_owner).debugTrace("PROXY IS " + proxy);
					//NCManager(_owner).debugTrace("ORIGURI IS " + _uriParam);
					//NCManager(_owner).debugTrace("NEWURI IS " + rtmpURL);
					//endif

					_owner.helperDone(this, true);
				}
			} catch (err:Error) {
				_owner.helperDone(this, false);
				throw err;
			}
		}

	} // clase FPADManager

} // package fl.video

