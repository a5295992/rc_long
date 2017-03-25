//视频播放
var flag = 0;
function videoPlay(video_path) {

	// alert(video_path);
	$("#video").css("height", "360");
	$("#video").html(
			"<a href='http://pseudo01.hddn.com/vod/demo.flowplayervod/flowplayer-700.flv'"
					+ "style='display:block;width:600px;height:360px' "
					+ " id='my52player'> </a> ");
	$("#play_list").css("display", "block")
	$("#video").append($("#play_list"));

	flowplayer("my52player", $player + "/flowplayer-3.2.11.swf", {
		clip : {
			url : "http://demo.cuplayer.com/file/ad6.mp4",
			autoPlay : false,
			autoBuffering : true
		},
		playlist : [ // playlist is an array of Clips, hence [...]

		             video_path, // simple playlist entry:
													// video
		'http://demo.cuplayer.com/file/ad3.mp4', { // small object as entry
			url : "http://demo.cuplayer.com/file/ad4.mp4",
			duration : 25
		} ],
		plugins : { // load one or more plugins
			controls : { // load the controls plugin

				// always: where to find the Flash object
				url : $player + '/flowplayer.controls-3.2.11.swf',

				// now the custom options of the Flash object
				playlist : true,
				backgroundColor : '#aedaff',
				tooltips : { // this plugin object exposes a 'tooltips'
								// object
					buttons : true,
					fullscreen : '全屏'
				}
			}
		},

		// set an event handler in the configuration
		onFinish : function() {
			var video_ids=$("input[name='video_id_id']");
			video_ids.each(function(){
				window.location.herf=base+"/video/"+$(this).val();
				return;
			});
		}
	});

}