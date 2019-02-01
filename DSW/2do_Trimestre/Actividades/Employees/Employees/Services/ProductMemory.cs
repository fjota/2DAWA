using Employees.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Employees.Services
{
  public static class ProductMemory
  {
    public static int autoIncrement = 0;

    public static List<Product> products = new List<Product>() {
      new Product(autoIncrement, "manola", "loco"),
      new Product(++autoIncrement, "cable", "matar")
    };
    
    public static void AddProduct(string name, string category)
    {
      products.Add(new Product(++autoIncrement,name, category));
    }

  }
}