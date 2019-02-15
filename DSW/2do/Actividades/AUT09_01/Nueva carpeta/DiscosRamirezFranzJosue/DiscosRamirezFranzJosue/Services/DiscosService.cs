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

    public IEnumerable<Tipo> ListTiposByIdterptreteId(int idInterprete)
    {
      IEnumerable<Tipo> listTipos = (from tipo in ListTipos()
                                    join tipoDisco in ListDiscoTipos() on tipo.IdTipo equals tipoDisco.IdTipo
                                    join discos in ListDiscos() on tipoDisco.IdDisco equals discos.IdDisco
                                    where discos.IdInterprete == idInterprete
                                    select tipo).Distinct();

      return listTipos;
    }

    public IEnumerable<Disco> ListDiscosByInterpreteIdAndTipoId(int idInterprete, int idTipo)
    {
      IEnumerable<Disco> listDiscos = from discos in ListDiscos()
                                      join tipoDisco in ListDiscoTipos() on discos.IdDisco equals tipoDisco.IdDisco
                                      join tipo in ListTipos() on tipoDisco.IdTipo equals tipo.IdTipo
                                      where tipoDisco.IdTipo == idTipo && discos.IdInterprete == idInterprete
                                      select discos;
      return listDiscos;
    }

    public IEnumerable<Disco> ListDiscosByTipoId(int idTipo)
    {
      IEnumerable<Disco> listDiscos = (from discos in ListDiscos()
                                      join tipoDisco in ListDiscoTipos() on discos.IdDisco equals tipoDisco.IdDisco
                                      join tipo in ListTipos() on tipoDisco.IdTipo equals tipo.IdTipo
                                      where tipoDisco.IdTipo == idTipo
                                      select discos).Distinct();

      return listDiscos;
    }

    public bool DeleteDiscoById(int id)
    {
      try
      {
        discosEntities.Entry(SearchDiscoById(id)).State = System.Data.Entity.EntityState.Deleted;
        discosEntities.SaveChanges();
        return true;
      }
      catch (Exception)
      {
        return false;
      }
    }

    public Disco SearchDiscoById(int id)
    {
      return discosEntities.Discoes.Where(item => item.IdDisco == id).SingleOrDefault();
    }

    public bool CreateDisco(Disco disco)
    {
      try
      {
        discosEntities.Discoes.Add(disco);
        discosEntities.SaveChanges();
        return true;
      }
      catch (Exception)
      {
        return false;
      }
    }

    public bool UpdateDisco(Disco disco)
    {
      try
      {
        discosEntities.Entry(disco).State = System.Data.Entity.EntityState.Modified;
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