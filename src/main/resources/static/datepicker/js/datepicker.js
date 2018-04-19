var todaydate = new Date();
$( function() {
    var dateFormat = "mm/dd/yy",
      from = $( ".from" )
        .datepicker({
          defaultDate: "+1w",
          changeMonth: true,
		  changeYear: true,
          numberOfMonths: 1,
          defaultDate: new Date()
        })
        .on( "change", function() {
          to.datepicker( "option", "minDate", getDate( this ) );
        }),
      
        DOB = $( ".DOB" )
        .datepicker({
          defaultDate: "+1w",
          changeMonth: true,
		  changeYear: true,
          numberOfMonths: 1,
          dateFormat: 'dd/mm/yy',
          yearRange: "1960:"+(todaydate.getFullYear())
        }),
        
        
      to = $( ".to" ).datepicker({
        defaultDate: "+1w",
        changeMonth: true,
		changeYear: true,
        numberOfMonths: 1,
        defaultDate: new Date(),
        maxDate:0,
        yearRange: "-70:+0"
      })
      .on( "change", function() {
        from.datepicker( "option", "maxDate", getDate( this ));
      }),
    
    Selectfrom = $( ".Selectfrom" )
    .datepicker({
      defaultDate: "+1w",
      changeMonth: true,
	  changeYear: true,
      numberOfMonths: 1,
      defaultDate: new Date(),
      minDate:new Date()
    })
    .on( "change", function() {
    	SelectTo.datepicker( "option", "minDate", getDate( this ) );
    }),
    
    
    SelectTo = $( ".SelectTo" )
    .datepicker({
      defaultDate: "+1w",
      changeMonth: true,
	  changeYear: true,
      numberOfMonths: 1,
      defaultDate: new Date(),
      minDate:new Date()
    })
    .on( "change", function() {
    	Selectfrom.datepicker( "option", "maxDate", getDate( this ) );
    });
 
    function getDate( element ) {
      var date;
      try {
        date = $.datepicker.parseDate( dateFormat, element.value );
      } catch( error ) {
        date = null;
      }
 
      return date;
    }
  } );