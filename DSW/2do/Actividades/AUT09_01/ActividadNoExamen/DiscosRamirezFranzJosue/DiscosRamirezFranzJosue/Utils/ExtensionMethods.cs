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
using System.Web.SessionState;
using System.Web.WebPages;

namespace DiscosRamirezFranzJosue.Utils
{
  public static class ExtensionMethods
  {       
    public static IEnumerable<Disco> OrderDiscos(this IEnumerable<Disco> collection, Sorted sort)
    {
      IEnumerable<Disco> discosOrdered = null;
      switch (sort)
      {
        case Sorted.DEFAULT:
          discosOrdered = collection.OrderByDescending(item => item.IdDisco);
          break;
        case Sorted.ASC:
          discosOrdered = collection.OrderBy(item => item.Titulo);
          break;
        case Sorted.DESC:
          discosOrdered = collection.OrderByDescending(item => item.Titulo);
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

    public static bool IsAdmin(this HttpSessionStateBase session, string key)
    {
      Usuario user = null;
      if (session[key] is Usuario)
      {
        user = session[key] as Usuario;
      }
      if (user != null && user.UsuariosGrupos.Any(g => g.Grupos.Nombre == "admin"))
      {
        return true;
      }
      return false;
    }

    public static bool IsAdmin(this Usuario usuario)
    {
      return usuario.UsuariosGrupos.Any(item => item.Grupos.Nombre == "admin");
    }

  }
}