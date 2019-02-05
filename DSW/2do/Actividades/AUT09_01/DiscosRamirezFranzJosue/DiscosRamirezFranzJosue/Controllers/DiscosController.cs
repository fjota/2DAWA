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
    private IInterpreteService interpreteService;

    public DiscosController(IDiscosService discosService, IInterpreteService interpreteService)
    {      
      this.discosService = discosService;
      this.interpreteService = interpreteService;
    }

    [HttpGet]
    public ActionResult Index()
    {

      var entidad = new DiscosEntities();
      var discosLista = entidad.Discoes.ToList();

      var tuple = new Tuple<IEnumerable<dynamic>, IEnumerable<Interprete>>(discosService.ListDiscos(), 
        interpreteService.ListInterpretes());
      return View(tuple);
    }
    
  }
}