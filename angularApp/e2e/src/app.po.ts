import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('https://dev.assignforce.revaturelabs.com');
  }

  newPage(){
    return browser.get('https://dev.assignforce.revaturelabs.com/home');
  }
  getLoginUsername(){
    return element(by.css('#username'));
  }
  getPassword(){
    return element(by.css('#password'));
  }

  getLogin(){
    return element(by.css('#Login'));
  }

  getLogout(){
    return element(by.css('button._md-nav-button'));
  }

  getFalseDate(){
    return element(by.css('#md-7-year-2018-9-1'));
  }

};