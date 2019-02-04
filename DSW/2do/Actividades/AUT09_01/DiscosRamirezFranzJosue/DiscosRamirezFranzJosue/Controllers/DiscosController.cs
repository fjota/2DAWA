using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using DiscosRamirezFranzJosue.Models;
using DiscosRamirezFranzJosue.Utils;
using DiscosRamirezFranzJosue.Services;
using DiscosRamirezFranzJosue.Repository;

namespace DiscosRamirezFranzJosue.Controllers
{
  public class DiscosController : Controller
  {

    private IDiscosService discosService;

    public DiscosController()
    {
      discosService = new DiscosService(new DiscosRepository());
    }

    [HttpGet]
    public ActionResult Index()
    {     
      return View(discosService.ListDiscos());
    }
    
  }
}