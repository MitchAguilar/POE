using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace Api.Controllers
{
    public class DividirController : ApiController
  {
    // GET: Dividir
    [System.Web.Http.HttpGet]
    public IHttpActionResult Index(double N1, double N2)
        {
            return Json(N1/N2);
        }
    }
}