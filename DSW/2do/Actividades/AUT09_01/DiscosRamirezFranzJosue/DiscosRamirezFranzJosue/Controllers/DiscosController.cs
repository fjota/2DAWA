using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using DiscosRamirezFranzJosue.Models;
using DiscosRamirezFranzJosue.Enums;
using DiscosRamirezFranzJosue.Services;

namespace DiscosRamirezFranzJosue.Controllers
{
  public class DiscosController : Controller
  {
    private IDiscosService discosService;
    private IInterpreteService interpreteService;

    public DiscosController(IDiscosService discosService, IInterpreteService interpreteService)
    {
      this.discosService = discosService;
      this.interpreteService = interpreteService;
    }

    [HttpGet]
    public ActionResult Index()
    {      
      var tuple = new Tuple<IEnumerable<Disco>, IEnumerable<Interprete>, IEnumerable<Tipo>>(discosService.ListDiscos(), 
        interpreteService.ListInterpretes(), discosService.ListTipos());
      return View(tuple);
    }

    [HttpPost]
    public ActionResult Index(Sorted orderDiscos)
    {
      ViewData["selectedOrder"] = (int) orderDiscos;
      var tuple = new Tuple<IEnumerable<Disco>, IEnumerable<Interprete>, IEnumerable<Tipo>>(discosService.ListDiscosOrdered(orderDiscos),
        interpreteService.ListInterpretes(), discosService.ListTipos());
      return View(tuple);
    }

  }
}