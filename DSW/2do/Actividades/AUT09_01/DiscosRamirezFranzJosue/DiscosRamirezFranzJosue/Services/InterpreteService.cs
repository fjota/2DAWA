using DiscosRamirezFranzJosue.Models;
using DiscosRamirezFranzJosue.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DiscosRamirezFranzJosue.Services
{
  public class InterpreteService : IInterpreteService
  {
    private IInterpreteRepository interpreteRepository;

    public InterpreteService(IInterpreteRepository interpreteRepository)
    {
      this.interpreteRepository = interpreteRepository;
    }

    public IEnumerable<dynamic> GetInterpretesById()
    {
      throw new NotImplementedException();
    }

    public IEnumerable<Interprete> ListInterpretes()
    {
      return interpreteRepository.ListInterpretes();
    }
  }
}