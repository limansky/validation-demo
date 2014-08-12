package com.github.limansky.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml
import net.liftmodules.validate.global._
import net.liftmodules.validate.Validators._

class ValidateAjax {
  def render() = {
    var name = ""
    var email = ""
    var agree = false

    "#name" #> (SHtml.ajaxText(name, name = _) >> ValidateRequired(() => name)) &
    "#email" #> (SHtml.ajaxText(email, (s: String) => email = s) >> ValidateEmail(() => email)) &
    "#agree" #> (SHtml.ajaxCheckbox(agree, agree = _) >> ValidateRequired(() => agree))
  }

}
