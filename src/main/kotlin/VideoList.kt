import kotlinx.html.js.onClickFunction
import models.Video
import react.*
import react.dom.*

@JsExport
class VideoList: RComponent<VideoListProps, RState>() {
    override fun RBuilder.render() {
        for (video in props.videos) {
            div( classes = "row"   ) {
                div(classes = "col s12 m5") {
                    div(classes = "card-panel teal") {
                        p {
                            key = video.id.toString()
                            attrs {
                                onClickFunction = {
                                    props.onSelectVideo(video)
                                }
                            }
                            if (video == props.selectedVideo) {
                                +"▶ "
                            }
                            +"${video.speaker}: ${video.title}"
                        }
                    }
                }

            }

        }
    }
}

external interface VideoListProps: RProps {
    var videos: List<Video>
    var selectedVideo: Video?
    var onSelectVideo: (Video) -> Unit
}
external interface VideoListState: RState {
    var selectedVideo: Video?
}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit): ReactElement {
    return child(VideoList::class) {
        this.attrs(handler)
    }
}