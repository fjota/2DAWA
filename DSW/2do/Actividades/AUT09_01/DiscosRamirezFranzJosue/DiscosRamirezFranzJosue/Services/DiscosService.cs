using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using DiscosRamirezFranzJosue.Repository;

namespace DiscosRamirezFranzJosue.Services
{
  public class DiscosService : IDiscosService
  {

    private IDiscosRepository discosRepository;

    public DiscosService(IDiscosRepository discosRepository)
    {
      this.discosRepository = discosRepository;
    }

    public IEnumerable<dynamic> ListDiscos()
    {
      return discosRepository.ListDiscos();
    }
  }
}