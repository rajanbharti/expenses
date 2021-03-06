//package com.tuplejump.expenses

import play.api.GlobalSettings
import play.api.mvc.{Handler, RequestHeader}

object Global extends GlobalSettings {

  override def onRouteRequest(request: RequestHeader): Option[Handler] = {
    (request.method, request.path) match {
      case ("GET", "/") => super.onRouteRequest(request)
      case ("POST", "/authenticate") => super.onRouteRequest(request)
      case ("GET", "/logout") => super.onRouteRequest(request)
      case ("GET", "/employee") =>
        val userType = request.session("userType")
        if (userType == "super") super.onRouteRequest(request)
        else Some(controllers.LoginController.home)
      case ("GET", "/vendor") =>
        val userType = request.session("userType")
        if ((userType == "super") || (userType == "admin")) super.onRouteRequest(request)
        else Some(controllers.LoginController.home)
      case ("GET", "/deleteEmployee") =>
        val userType = request.session("userType")
        if (userType == "super") super.onRouteRequest(request)
        else Some(controllers.LoginController.home)
      case ("GET", "/deleteVendor") =>
        val userType = request.session("userType")
        if ((userType == "super") || (userType == "admin")) super.onRouteRequest(request)
        else Some(controllers.LoginController.home)
      case ("GET", "/getFile") =>
        val userType = request.session("userType")
        if (userType == "super") super.onRouteRequest(request)
        else Some(controllers.LoginController.home)
      case ("GET", "/reviewPay") =>
        val userType = request.session("userType")
        if ((userType == "super") || (userType == "admin")) super.onRouteRequest(request)
        else Some(controllers.LoginController.home)
      case ("POST", "/approve") =>
        val userType = request.session("userType")
        if ((userType == "super") || (userType == "admin")) super.onRouteRequest(request)
        else Some(controllers.LoginController.home)
      case ("POST", "/deny") => val userType = request.session("userType")
        if ((userType == "super") || (userType == "admin")) super.onRouteRequest(request)
        else Some(controllers.LoginController.home)
      case _ => {
        super.onRouteRequest(request)
      }
    }
  }


}
