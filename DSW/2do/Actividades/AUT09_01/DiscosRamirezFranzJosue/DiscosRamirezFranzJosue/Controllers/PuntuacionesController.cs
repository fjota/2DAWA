using DiscosRamirezFranzJosue.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DiscosRamirezFranzJosue.Controllers
{
  public class PuntuacionesController : Controller
  {

    public ActionResult Cliente(int id)
    {

      DiscosEntities context = new DiscosEntities();
      var puntuationesClientes = context.Puntuacions.Where(item => item.Idcliente == id);
      var puntos = context.Puntuacions.ToList();

      return View(puntuationesClientes);

    }
  }
}