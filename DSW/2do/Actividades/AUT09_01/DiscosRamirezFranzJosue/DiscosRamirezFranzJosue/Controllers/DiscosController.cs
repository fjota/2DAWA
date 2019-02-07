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
      var discos = discosService.ListDiscos();
      return View(discos);
    }

    [HttpPost]
    public ActionResult Index(Sorted orderDiscos)
    {      
      OrderModel.SortedList.Find(item => item.Selected == true).Selected = false;
      OrderModel.SortedList.Find(item => int.Parse(item.Value) == (int)orderDiscos).Selected = true;
      var discosOrdered = discosService.ListDiscosOrdered(orderDiscos);
      return View(discosOrdered);
    }

    [ChildActionOnly]
    public PartialViewResult FilterDiscos()
    {
      var tuple = new Tuple<IEnumerable<Interprete>, IEnumerable<Tipo>>(interpreteService.ListInterpretes(), discosService.ListTipos());
      return PartialView("_FilterDiscos", tuple);
    }

  }
}