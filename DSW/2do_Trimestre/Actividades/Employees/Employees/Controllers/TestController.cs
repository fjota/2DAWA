using Employees.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Employees.Controllers
{
 
  public class TestController : Controller
  {
    public ViewResult GetCustomer()
    {
      Customer cus = new Customer
      {
        Address = "direccion",
        CustomerName = "SADADasdas"
      };

      return View(cus);      
    }

  }
}