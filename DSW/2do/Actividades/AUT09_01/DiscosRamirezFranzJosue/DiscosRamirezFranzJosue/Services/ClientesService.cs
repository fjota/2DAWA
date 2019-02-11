using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
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

    public bool RemoveCliente(Cliente cliente)
    {
      try
      {
        discosEntities.Clientes.Attach(cliente);
        discosEntities.Clientes.Remove(cliente);
        discosEntities.SaveChanges();
        return true;
      }
      catch (Exception)
      {
        return false;
      }
    }

    public bool DeleteClienteById(int id)
    {
      try
      {

        discosEntities.Clientes.Remove(SearchClienteById(id));
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

    public Cliente SearchClienteById(int id)
    {
      return discosEntities.Clientes.First(item => item.id == id);
    }

    public bool UpdateCliente(Cliente cliente)
    {
      try
      {
        /*discosEntities.Clientes.Add(cliente);
        discosEntities.Entry(cliente).State = EntityState.Modified;*/
        discosEntities.Entry(cliente).State = EntityState.Modified;
        discosEntities.SaveChanges();
        return true;
      }
      catch (Exception)
      {
        return false;
      }
    }
  }
}