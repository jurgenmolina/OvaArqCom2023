const charts = document.querySelectorAll(".chart");

charts.forEach(function (chart) {
  var ctx = chart.getContext("2d");
  var myChart = new Chart(ctx, {
    type: "bar",
    data: {
      labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
      datasets: [
        {
          label: "# of Votes",
          data: [12, 19, 3, 5, 2, 3],
          backgroundColor: [
            "rgba(255, 99, 132, 0.2)",
            "rgba(54, 162, 235, 0.2)",
            "rgba(255, 206, 86, 0.2)",
            "rgba(75, 192, 192, 0.2)",
            "rgba(153, 102, 255, 0.2)",
            "rgba(255, 159, 64, 0.2)",
          ],
          borderColor: [
            "rgba(255, 99, 132, 1)",
            "rgba(54, 162, 235, 1)",
            "rgba(255, 206, 86, 1)",
            "rgba(75, 192, 192, 1)",
            "rgba(153, 102, 255, 1)",
            "rgba(255, 159, 64, 1)",
          ],
          borderWidth: 1,
        },
      ],
    },
    options: {
      scales: {
        y: {
          beginAtZero: true,
        },
      },
    },
  });
});

$(document).ready(function () {
  $(".data-table").each(function (_, table) {
    $(table).DataTable();
  });
});

$(document).ready(function () {
  $('a[data-target="#confirmModal"]').click(function (e) {
    e.preventDefault();
    $('#confirmModal').modal('show');
  });
});

$('#confirmModal').on('hidden.bs.modal', function (e) {
  // Habilitar la pantalla anterior
  $('body').removeClass('modal-open');
  $('body').css('overflow', 'auto');
})

$(document).on('click', '#confirmDelete', function () {
  // Cerrar la ventana emergente
  $('#confirmModal').modal('hide');
});

$(document).on('click', '#btnCancelar', function () {
  // Cerrar la ventana emergente
  $('#confirmModal').modal('hide');
});

$(document).on('click', '#btnClose', function () {
  // Cerrar la ventana emergente
  $('#confirmModal').modal('hide');
});

$(document).ready(function () {
  $('#listado').DataTable({
    "language": {
      "url": "//cdn.datatables.net/plug-ins/1.10.25/i18n/Spanish.json"
    }
  });
});

$(document).ready(function () {
  $('#listado2').DataTable({
    "language": {
      "url": "//cdn.datatables.net/plug-ins/1.10.25/i18n/Spanish.json"
    }
  });
});

function validarNumeros(input) {
  var regex = /[^0-9]/g;
  input.value = input.value.replace(regex, "");
}

