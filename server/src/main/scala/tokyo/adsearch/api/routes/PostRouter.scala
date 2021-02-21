package tokyo.adsearch.api.routes

import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird.{GET, POST, _} // TODO: Where does p define?

import tokyo.adsearch.api.controllers.Post

class PostRouter @Inject()(controller: Post) extends SimpleRouter {
  val prefix = "/v1/posts"

  def  link(id: PostId): String = {
    val url = prefix / id.toString
    url.toString()
  }

  override def routes: Routes = {
    case GET(p"/") =>
      controller.index

    case POST(p"/") =>
      controller.process

    case GET(p"/$id") =>
      controller.show(id)
  }
}
