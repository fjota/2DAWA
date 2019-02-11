using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using DiscosRamirezFranzJosue.Models;
using DiscosRamirezFranzJosue.Services;

namespace DiscosRamirezFranzJosue.Controllers
{
  public class ClientesController : Controller
  {
    private IClientesService clientesService;

    public ClientesController(IClientesService clientesService)
    {
      this.clientesService = clientesService;
    }

    [HttpGet]
    public ViewResult Index()
    {
      return View(clientesService.ListClientes().OrderByDescending(item => item.id));
    }

    [HttpGet]
    public ViewResult RegisterCliente()
    {
      return View();
    }

    [HttpPost]
    public ActionResult RegisterCliente(Cliente cliente)
    {
      if (ModelState.IsValid)
      {
        cliente.FechaRegistro = DateTime.Now;
        clientesService.CreateCliente(cliente);
        return RedirectToAction("Index");
      }
      else
      {
        return View();
      }           
    }

    public ActionResult Delete(int id)
    {
      clientesService.DeleteClienteById(id);
      return RedirectToAction("Index");
    }

    [HttpGet]
    public ViewResult Edit(int id)
    {
      return View(clientesService.SearchClienteById(id));
    }

    [HttpPost]
    public ActionResult Edit(Cliente cliente)
    {
      clientesService.UpdateCliente(cliente);
      return RedirectToAction("Index");
    }

    public ActionResult Details(int id)
    {
      return View(clientesService.SearchClienteById(id));
    }


  }
}