package controllers

import javax.inject.Inject

import play.api.libs.json._
import play.api.mvc._
import play.api.libs.streams.ActorFlow
import akka.actor.ActorSystem
import akka.stream.Materializer

import actors.ClientConnection.{ClientEvent, clientEventFormat}
import actors.ClientConnection

import play.api.mvc.WebSocket.MessageFlowTransformer
import akka.actor._

class Application @Inject() (cc: ControllerComponents, clientConnectionFactory: ClientConnection.Factory) (
    implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {

  /**
   * The index page.
   */
  def index = Action { implicit req =>
    Ok(views.html.index())
  }

  /**
   * The WebSocket
   */

  //implicit val eventFormat = Json.format[ClientEvent]()

  implicit val messageFlowTransformer = MessageFlowTransformer.jsonMessageFlowTransformer[ClientEvent, ClientEvent]

  def stream(email: String) = WebSocket.accept[ClientEvent, ClientEvent] { request =>
    ActorFlow.actorRef { out =>
      Props(clientConnectionFactory(email))
    }
  }
}