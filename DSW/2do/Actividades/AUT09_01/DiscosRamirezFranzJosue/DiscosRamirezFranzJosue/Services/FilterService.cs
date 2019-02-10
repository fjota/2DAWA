using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using DiscosRamirezFranzJosue.Enums;
using DiscosRamirezFranzJosue.Models;

namespace DiscosRamirezFranzJosue.Services
{
  public class FilterService : IFilterService
  {
    private DiscosEntities discosEntities;

    public FilterService()
    {
      discosEntities = new DiscosEntities();
    }

    public IEnumerable<Disco> ListDiscosOrdered(Sorted sort)
    {
      IEnumerable<Disco> discos = null;
      switch (sort)
      {
        case Sorted.DEFAULT:
          discos = discosEntities.Discoes.OrderByDescending(item => item.IdDisco);
          break;
        case Sorted.ASC:
          discos = discosEntities.Discoes.OrderBy(item => item.Interprete.Interprete1);
          break;
        case Sorted.DESC:
          discos = discosEntities.Discoes.OrderByDescending(item => item.Interprete.Interprete1);
          break;
        case Sorted.DATE:
          discos = discosEntities.Discoes.OrderByDescending(item => item.Agno);
          break;
      }
      return discos;
    }
  }
}