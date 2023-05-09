window.addEventListener('beforeunload', function(event) {

  event.preventDefault();
  event.returnValue = '';


  const confirmationMessage = 'Are you sure you want to leave the page?';
  event.returnValue = confirmationMessage;
  return confirmationMessage;
});

goBackButton.addEventListener('click', function() {

  window.history.back();
});

