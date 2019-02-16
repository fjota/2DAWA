using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using DiscosRamirezFranzJosue.Models;

namespace DiscosRamirezFranzJosue.Services
{
  public class UsuariosServices : IUsuariosServices
  {
    private DiscosEntities discosEntities;

    public UsuariosServices()
    {
      discosEntities = new DiscosEntities();
    }

    public Usuario FindUserByLoginAndPassword(string login, string password)
    {
      Usuario usuario = discosEntities.Usuarios.Where(user => user.Login == login && user.Password == password.ToLower()).FirstOrDefault();
      return usuario;
    }
  }
}