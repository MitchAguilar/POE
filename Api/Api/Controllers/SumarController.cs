using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace Api.Controllers
{
    public class SumarController : ApiController
    {
        // GET: Sumar
        [System.Web.Http.HttpGet]
        public IHttpActionResult Index(int N1,int N2)
        {
            return Json(N1+N2);
        }
    }
}