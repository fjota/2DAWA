﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DiscosRamirezFranzJosue.Controllers
{
  public class ErrorHandlerController : Controller
  {
    public ActionResult Error()
    {
      return View();
    }     
  }
}