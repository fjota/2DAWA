using DiscosRamirezFranzJosue.Filters;
using DiscosRamirezFranzJosue.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DiscosRamirezFranzJosue.Controllers
{
  [Authorize] 
  public class DiscograficaController : Controller
  {
    
    public ActionResult Index()
    {
      var context = new DiscosEntities();
      var lista = context.Discograficas;
      return View(lista.OrderByDescending(item => item.IdDiscografica));
    }

    [AdminFilter]
    [HttpGet]
    public ActionResult CreateDiscografica()
    {
      return View();
    }

    [AdminFilter]
    [HttpPost]
    public ActionResult CreateDiscografica(Discografica discografica)
    {
      if (ModelState.IsValid)
      {
        var context = new DiscosEntities();
        context.Discograficas.Add(discografica);
        context.SaveChanges();
        return RedirectToAction("Index");
      }
      return View();
    }

    [HttpGet]
    [CustomerFilter]
    public ActionResult ShowDiscos(int IdDiscografica)
    {
      var context = new DiscosEntities();
      var lista = context.Discoes.Where(item => item.IdDiscografica == IdDiscografica).ToList();
      return View(lista);
    }

  }
}