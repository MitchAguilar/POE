using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Api.Controllers
{
  public class RestarController : Controller
  {
    // GET: Restar
    [System.Web.Http.HttpGet]
    public ActionResult Index(int N1, int N2)
    {
      return Json(N1 - N2);
    }
  }
}