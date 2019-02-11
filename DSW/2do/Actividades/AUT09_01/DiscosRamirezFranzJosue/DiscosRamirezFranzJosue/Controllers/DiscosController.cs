using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using DiscosRamirezFranzJosue.Utils;
using DiscosRamirezFranzJosue.Models;
using DiscosRamirezFranzJosue.Enums;
using DiscosRamirezFranzJosue.Services;

namespace DiscosRamirezFranzJosue.Controllers
{
  public class DiscosController : Controller
  {
    private IDiscosService discosService;
    private IInterpreteService interpreteService;
    private IFilterService filterService;

    public DiscosController(IDiscosService discosService, IInterpreteService interpreteService, IFilterService filterService)
    {
      this.discosService = discosService;
      this.interpreteService = interpreteService;
      this.filterService = filterService;
    }

    [HttpGet]
    public ActionResult Index(int? interprete, int? tipoDisco, Sorted? orderDiscos)
    {  
      OrderModel.SortedList.Find(item => item.Selected == true).Selected = false;
      OrderModel.SortedList.Find(item => int.Parse(item.Value) == (orderDiscos != null ? (int)orderDiscos : 0)).Selected = true;

      ViewData["interpreteSelected"] = interprete != null ? (int)interprete : 0;
      ViewData["tipoDiscoSelected"] = tipoDisco != null ? (int)tipoDisco : 0;

      if (interprete == null && tipoDisco == null)
      {
        return View(filterService.ListDiscosOrdered(orderDiscos != null ? (Sorted)orderDiscos : 0));
      }
      if (tipoDisco == null)
      {
        IEnumerable<Disco> discosByInterprete = filterService.ListDiscosOrdered(orderDiscos != null ? (Sorted)orderDiscos : 0)
        .Where(x => x.Interprete.IdInterprete == (int)interprete);
        return View(discosByInterprete);
      }
      if (interprete == null)
      {
        return View(discosService.ListDiscosByTipoId((int)tipoDisco).OrderDiscos(orderDiscos != null ? (Sorted)orderDiscos : 0));       
      }
                             
      return View(discosService.ListDiscosByInterpreteIdAndTipoId((int)interprete, (int)tipoDisco).OrderDiscos(orderDiscos != null ? (Sorted)orderDiscos : 0));
    }
   
    [ChildActionOnly]
    public PartialViewResult FilterDiscos(int? idInterprete, int? idTipoDisco)
    {
     
      ViewData["interpreteSelected"] = idInterprete;
      ViewData["tipoDiscoSelected"] = idTipoDisco;
      var tuple = new Tuple<IEnumerable<Interprete>, IEnumerable<Tipo>>(
        idTipoDisco == 0 ? interpreteService.ListInterpretes() : interpreteService.ListInterpretesByIdTipoDisco((int)idTipoDisco), 
        idInterprete == 0 ? discosService.ListTipos() : discosService.ListTiposByIdterptreteId((int)idInterprete)); 
      return PartialView("_FilterDiscos", tuple);
    }

  }
}