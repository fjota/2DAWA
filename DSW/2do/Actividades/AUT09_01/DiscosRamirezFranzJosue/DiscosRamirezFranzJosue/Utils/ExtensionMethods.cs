using DiscosRamirezFranzJosue.Enums;
using DiscosRamirezFranzJosue.Models;
using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace DiscosRamirezFranzJosue.Utils
{
  public static class ExtensionMethods
  {    
    public static ExpandoObject ToExpando(this object anonymousObject)
    {
      IDictionary<string, object> anonymousDictionary = new RouteValueDictionary(anonymousObject);
      IDictionary<string, object> expando = new ExpandoObject();
      foreach (var item in anonymousDictionary)
      {
        expando.Add(item);
      }
      return expando as ExpandoObject;
    }

    public static IEnumerable<Disco> OrderDiscos(this IEnumerable<Disco> collection, Sorted sort)
    {
      IEnumerable<Disco> discosOrdered = null;
      switch (sort)
      {
        case Sorted.DEFAULT:
          discosOrdered = collection.OrderByDescending(item => item.IdDisco);
          break;
        case Sorted.ASC:
          discosOrdered = collection.OrderBy(item => item.Interprete.Interprete1);
          break;
        case Sorted.DESC:
          discosOrdered = collection.OrderByDescending(item => item.Interprete.Interprete1);
          break;
        case Sorted.DATE:
          discosOrdered = collection.OrderByDescending(item => item.Agno);
          break;
      }      
      return discosOrdered;
    }

    public static string HashStringSHA256(this string value)
    {
      string valueHashed = null;
      using (SHA256 sha256 = SHA256.Create())
      {
        try
        {
          byte[] input = Encoding.UTF8.GetBytes(value);
          byte[] hashValue = sha256.ComputeHash(input);
          foreach (var item in hashValue)
          {
            valueHashed += $"{item:X2}";
          }
        }
        catch (Exception)
        {
        }
      }
      return valueHashed;
    }

  }
}