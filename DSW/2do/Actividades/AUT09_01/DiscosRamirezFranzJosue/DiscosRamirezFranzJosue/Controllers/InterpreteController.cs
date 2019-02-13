using DiscosRamirezFranzJosue.Models;
using DiscosRamirezFranzJosue.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DiscosRamirezFranzJosue.Controllers
{
  public class InterpreteController : Controller
  {
    private IInterpreteService interpreteService;

    public InterpreteController(IInterpreteService interpreteService)
    {
      this.interpreteService = interpreteService;
    }

    public ActionResult Index()
    {
      return View(interpreteService.ListInterpretes().OrderByDescending(item => item.IdInterprete));
    }

    [HttpGet]
    public ActionResult Create()
    {
      return View();
    }

    [HttpPost]
    public ActionResult Create(Interprete interprete)
    {
      if (ModelState.IsValid)
      {
        interpreteService.CreateInterprete(interprete);
        return RedirectToAction("Index");
      }
      return View();
    }
    
    public ActionResult Delete(int IdInterprete)
    {
      interpreteService.DeleteInterpreteById(IdInterprete);
      return RedirectToAction("Index");
    }

    [HttpGet]
    public ActionResult Details(int IdInterprete)
    {
      return View(interpreteService.SearchInterpreteById(IdInterprete));
    }

    public ActionResult Edit(int IdInterprete)
    {
      return View(interpreteService.SearchInterpreteById(IdInterprete));
    }

    [HttpPost]
    public ActionResult Edit(Interprete interprete)
    {
      if (ModelState.IsValid)
      {
        interpreteService.UpdateInterprete(interprete);
        return RedirectToAction("Index");
      }
      return View();
    }

  }
}