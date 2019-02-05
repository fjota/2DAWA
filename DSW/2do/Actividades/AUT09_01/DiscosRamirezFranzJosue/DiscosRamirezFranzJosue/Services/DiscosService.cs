using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using DiscosRamirezFranzJosue.Models;
using DiscosRamirezFranzJosue.Enums;

namespace DiscosRamirezFranzJosue.Services
{
  public class DiscosService : IDiscosService
  {
    private DiscosEntities discosEntities;

    public DiscosService(DiscosEntities discosEntities)
    {
      this.discosEntities = discosEntities;
    }

    public IEnumerable<Disco> ListDiscos()
    {
      return discosEntities.Discoes;
    }
    
    public IEnumerable<Tipo> ListTipos()
    {
      return discosEntities.Tipoes;
    }

    public IEnumerable<Disco> ListDiscosOrdered(Sorted sort)
    {
      IEnumerable<Disco> discos = null;
      switch (sort)
      {
        case Sorted.DEFAULT:
          discos = ListDiscos().OrderBy(item => item.Interprete.Interprete1);
          break;
        case Sorted.ASC:
          discos = ListDiscos().OrderBy(item => item.Interprete.Interprete1);
          break;
        case Sorted.DESC:
          discos = ListDiscos().OrderByDescending(item => item.Interprete.Interprete1);
          break;
        case Sorted.DATE:
          discos = ListDiscos().OrderByDescending(item => item.Agno);
          break;
      }
      return discos;
    }    
  }
}