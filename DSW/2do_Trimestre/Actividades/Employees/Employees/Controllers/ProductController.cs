using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Employees.Models;
using Employees.Services;

namespace Employees.Controllers
{
  public class ProductController : Controller
  {
      
    public ActionResult Index()
    {     
      return View(ProductMemory.products);
    }

    [HttpPost]
    public ActionResult Index(Product product)
    {     
      ProductMemory.AddProduct(product.Name, product.Category);
      return View(ProductMemory.products);
    }

    public ActionResult Create()
    {
      return View();
    }
  }
}