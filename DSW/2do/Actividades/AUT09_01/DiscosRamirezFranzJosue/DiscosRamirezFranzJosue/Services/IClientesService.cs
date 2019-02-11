using DiscosRamirezFranzJosue.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiscosRamirezFranzJosue.Services
{
  public interface IClientesService
  {
    bool CreateCliente(Cliente cliente);
    IEnumerable<Cliente> ListClientes();
    bool DeleteClienteById(int id);
    Cliente SearchClienteById(int id);
    bool UpdateCliente(Cliente cliente);
    bool RemoveCliente(Cliente cliente);
  }
}
