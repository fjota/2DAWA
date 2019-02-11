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

    public DiscosService()
    {
      discosEntities = new DiscosEntities();
    }

    public IEnumerable<DiscoTipo> ListDiscoTipos()
    {
      return discosEntities.DiscoTipoes;
    }

    public IEnumerable<Disco> ListDiscos()
    {
      return discosEntities.Discoes;
    }

    public IEnumerable<Tipo> ListTipos()
    {
      return discosEntities.Tipoes;
    }

    public IEnumerable<Tipo> ListTiposByDiscosId(IEnumerable<Disco> discos)
    {
      //TODO
      IEnumerable<Tipo> listTipos = (from tipoDisco in ListDiscoTipos()
                                    join discs in discos on tipoDisco.IdDisco equals discs.IdDisco
                                    join tipos in ListTipos() on tipoDisco.IdTipo equals tipos.IdTipo
                                    select tipos).Distinct();
      /*IEnumerable<Tipo> listTipos = from tipo in ListTipos()
                                    join tipoDisco in ListDiscoTipos() on tipo.IdTipo equals tipoDisco.IdTipo
                                    join discosL in discos on tipoDisco.IdDisco equals discosL.IdDisco*/

      return listTipos;
    }
    
  }
}