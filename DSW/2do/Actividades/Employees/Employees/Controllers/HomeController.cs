using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Employees.Controllers
{
  public class HomeController : Controller
  {
    // GET: Home
    public ViewResult Index()
    {
      return View();
    }

    public string Index2(int? id)
    {
      return $"Index 2 , id={id}";
    }

    public String Foo()
    {
      return "Supersecreto";
    }

    private String Foo2()
    {
      return "Supersecreto";
    }

  }
}