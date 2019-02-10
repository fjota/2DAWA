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

      IEnumerable<Tipo> listTipos = (from tipoDisco in ListDiscoTipos()
                                    join discs in discos on tipoDisco.IdDisco equals discs.IdDisco
                                    join tipos in ListTipos() on tipoDisco.IdTipo equals tipos.IdTipo
                                    select tipos).Distinct();

      return listTipos;
    }

    public IEnumerable<Disco> ListDiscosByInterpreteAndTipoDisco(IEnumerable<Interprete> interpretes, IEnumerable<Tipo> tipo)
    {
      throw new NotImplementedException();
    }
  }
}