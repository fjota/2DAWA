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

      ViewData["interpreteSelected"] = interprete;
      ViewData["tipoDiscoSelected"] = tipoDisco;

      if (interprete == null && tipoDisco == null)
      {
        return View(filterService.ListDiscosOrdered(orderDiscos != null ? (Sorted)orderDiscos : 0));
      }
      if (tipoDisco == null)
      {
        IEnumerable<Disco> discos1 = filterService.ListDiscosOrdered(orderDiscos != null ? (Sorted)orderDiscos : 0)
        .Where(x => x.Interprete.IdInterprete == (int)interprete);
        return View(discos1);
      }
      /*var discos = filterService.ListDiscosOrdered(orderDiscos != null ? (Sorted)orderDiscos : 0).
        Where(x => x.Interprete.IdInterprete == (interprete != null ? (int)interprete : 1));*/
      var discos = filterService.ListDiscosOrdered(orderDiscos != null ? (Sorted)orderDiscos : 0)
         .Where(x => x.Interprete.IdInterprete == (interprete != null ? (int)interprete : 1));

      var discoTipo = discosService.ListDiscoTipos().Where(item => item.IdTipo == (tipoDisco != null ? (int)tipoDisco : 1)).ToList();

      var peura = (from discosEl in discos
                  join discosTi in discoTipo on discosEl.IdDisco equals discosTi.IdDisco
                  select discosEl).ToList();


      
      return View(peura);
    }
   
    [ChildActionOnly]
    public PartialViewResult FilterDiscos(int? idInterprete, int? idTipoDisco, IEnumerable<Disco> discos)
    {           
      ViewData["interpreteSelected"] = idInterprete != null ? idInterprete : 0;
      ViewData["tipoDiscoSelected"] = idTipoDisco != null ? idTipoDisco : 0;
      var tuple = new Tuple<IEnumerable<Interprete>, IEnumerable<Tipo>>(interpreteService.ListInterpretes(), discosService.ListTiposByDiscosId(discos));
      return PartialView("_FilterDiscos", tuple);
    }

  }
}