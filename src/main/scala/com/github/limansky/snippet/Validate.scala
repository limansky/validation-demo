package com.github.limansky.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml
import net.liftmodules.validate.global._
import net.liftmodules.validate.Validators._

class Validate {
  def render() = {
    var name = ""
    var email = ""

    "#name" #> (SHtml.text(name, name = _) >> ValidateRequired(() => name)) &
    "#email" #> SHtml.email(email, (s: String) => email = s)
  }
}
