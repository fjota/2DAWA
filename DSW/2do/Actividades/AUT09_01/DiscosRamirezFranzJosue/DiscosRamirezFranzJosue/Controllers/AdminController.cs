using DiscosRamirezFranzJosue.Filters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DiscosRamirezFranzJosue.Controllers
{
  [Authorize]
  [AdminFilter]
  public class AdminController : Controller
  {
    
    public ActionResult Index()
    {
      return View();
    }
  }
}