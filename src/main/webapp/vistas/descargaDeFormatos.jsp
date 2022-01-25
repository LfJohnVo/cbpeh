<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
  <h4 class="h4 mb-0 text-gray-800">Descarga de Formatos</h4>
</div>
<style>
  /* Remove default bullets */
  ul, #listaFormatos {
    list-style-type: none;
  }

  /* Remove margins and padding from the parent ul */
  #listaFormatos {
    margin: 0;
    padding: 0;
  }

  /* Style the caret/arrow */
  .caret {
    color:black;
    cursor: pointer;
    user-select: none; /* Prevent text selection */
  }

  .nested li a:hover{
    text-decoration:none !important;
  }
  /* Create the caret/arrow with a unicode, and style it */
  .caret::before {
    font-family: 'Font Awesome 5 Free';
    content: "\f07b";
    color: black;
    display: inline-block;
    margin-right: 6px;
  }

  /* Rotate the caret/arrow icon when clicked on (using JavaScript) */
  .caret-down::before {
    font-family: 'Font Awesome 5 Free';
    content: "\f07c";
    color: blue;
    display: inline-block;
    margin-right: 6px;
  }

  /* Hide the nested list */
  .nested {
    display: none;
  }

  /* Show the nested list when the user clicks on the caret/arrow (with JavaScript) */
  .active {
    display: block;
  }
</style>
<div class="row">
  <div class="col-lg-12 col-md-12 col-sm-12 col-12">
    <div class="card">
      <div class="card-body">
        <%-- <h5 class="card-title">Formato 1</h5>
        <p class="card-text">Descripci&oacute;n del formato 1</p>
        <a
          href="/cbpeh/recursos/formatos/dummy.pdf"
          download
          class="btn btn-primary"
          ><i class="fas fa-download mr-2"></i>Descargar</a
        > --%>
        <ul id="listaFormatos">
          <li data-action="toggle1"><span class="caret">Atención Ciudadana</span>
            <ul class="nested">
              <li><a class="text-dark" href="/cbpeh/recursos/formatos/Atencion_Ciudadana/Formato Apertura de Expediente.docx"
          download><i class="fas fa-file-word mr-2 text-primary"></i>Formato de Apertura de Expediente</a></li>
              <li><a class="text-dark" href="/cbpeh/recursos/formatos/Atencion_Ciudadana/Formato Apertura de Expediente.pdf"
          download><i class="fas fa-file-pdf mr-2 text-danger"></i>Formato de Apertura de Expediente</a></li>
              <li><a class="text-dark" href="/cbpeh/recursos/formatos/Atencion_Ciudadana/Formato Constancia de Atención.docx"
          download><i class="fas fa-file-word mr-2 text-primary"></i>Formato Constancia de Atención</a></li>
              <li><a class="text-dark" href="/cbpeh/recursos/formatos/Atencion_Ciudadana/Formato Constancia de Atención.pdf"
          download><i class="fas fa-file-pdf mr-2 text-danger"></i>Formato Constancia de Atención</a></li>
            </ul>
          </li>
          <li data-action="toggle2"><span class="caret">Coordinación de Búsqueda</span>
            <ul class="nested">
               <li><a class="text-dark" href="/cbpeh/recursos/formatos/Coordinacion_de_ busqueda/ACTA DE ENTREVISTA.pdf"
          download><i class="fas fa-file-pdf mr-2 text-danger"></i>Acta de Entrevista</a></li>
               <li><a class="text-dark" href="/cbpeh/recursos/formatos/Coordinacion_de_ busqueda/FORMATO DE VISITA.pdf"
          download><i class="fas fa-file-pdf mr-2 text-danger"></i>Formato de Visita</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>
</div>
<script>
  $(document).ready(function () {
   
    var toggler = document.getElementsByClassName("caret");
    var i;

    for (i = 0; i < toggler.length; i++) {
      toggler[i].addEventListener("click", function() {
        this.parentElement.querySelector(".nested").classList.toggle("active");
        this.classList.toggle("caret-down");
      });
    }
  });
</script>
