function getJSONloader(){
  $.getJSON('data/index.json', function(data) {
    jsonDron = drones;
    printDron(jsonDron.dron);
  });
}

function printDron(listDron){

  $('#contenido').html("");

  $.each( listDron, function( key, oDron){
    let card = `<div class="col-md-4">
                  <div class="card text-center">
                    <div class="card-block">

                      <img src="${oDron.cover}" alt="" width="100" class="img-fluid">

                      <div>

                        <h4 class="card-title">${oDron.name}</h4>

                        <h5 class="card-title">${oDron.precio}</h5>

                        <button class="btn btn-primary" data-toggle="modal" data-target="#cantidades" onclick="modalVideo(${oSerie.id}, '${oSerie.name}', '${oSerie.price}')">Detalles</button>

                      </div>
                    </div>
                  </div>
                </div>`;
      $('#contenido').append(card);
  });

}
