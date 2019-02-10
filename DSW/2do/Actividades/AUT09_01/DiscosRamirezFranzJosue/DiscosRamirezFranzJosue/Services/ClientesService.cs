using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using DiscosRamirezFranzJosue.Models;

namespace DiscosRamirezFranzJosue.Services
{
  public class ClientesService : IClientesService
  {

    private DiscosEntities discosEntities;

    public ClientesService()
    {
      discosEntities = new DiscosEntities();
    }
    public bool CreateCliente(Cliente cliente)
    {
      try
      {
        discosEntities.Clientes.Add(cliente);
        discosEntities.SaveChanges();
        return true;
      }
      catch (Exception)
      {
        return false;
      }
      
    }

    public IEnumerable<Cliente> ListClientes()
    {
      return discosEntities.Clientes;
    }
  }
}