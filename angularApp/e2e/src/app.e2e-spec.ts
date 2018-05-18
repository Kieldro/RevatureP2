import { AppPage } from './app.po';
import { browser, by, element } from 'protractor';


describe('Protractor Demo App', function() {
  let page: AppPage;

beforeAll(() => {
  browser.ignoreSynchronization = true;
})

afterAll(()=> {

}) 
beforeEach(() => {
   
    page = new AppPage();
});



  it('Can login to Salesforce as a trainer', function(){
    let theUsername:string = '#username';
    let thePassword: string = '#password';
    let loginButton: string = '#Login';
     page.navigateTo();
     page.getLoginUsername();
     element(by.css(theUsername)).sendKeys('test.trainer@revature.com.int1');
     page.getPassword();
     element(by.css(thePassword)).sendKeys('trainer123');
     page.getLogin();
     element(by.css(loginButton)).click();
    browser.sleep(5000);
  });


it('Can access the batches page', function(){
  let theBatchButton: string = '/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a/span';
  element(by.xpath(theBatchButton)).click();
});

it('Can access the locations page', function(){
  let theBatchButton: string = '/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a/span/span';
  element(by.xpath(theBatchButton)).click();
});
it('Can access the curricula page', function(){
  let theBatchButton: string = '/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[4]/a/span/span';
  element(by.xpath(theBatchButton)).click();
});
it('Can access the trainers page', function(){
  let theBatchButton: string = '/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]/a/span';
  element(by.xpath(theBatchButton)).click();
});

// it('Cannot access an invlaid start date', function(){
//   let theClndrButton: string  = 'md-datepicker-input md-input';
//   //let theDate: string = '#md-7-year-2018-9-1';
//   element(by.css(theClndrButton)).click();
//   expect(page.getFalseDate()).toBeFalsy;
//   element(by.css('#md-date-pane1140')).click();
// });


it('', function(){
  
});


it('', function(){
  
});

it('', function(){
  
});

  it('Can logout of Salesforce',function(){
    let theLogout: string = 'button._md-nav-button';
    page.getLogout();
     element(by.css(theLogout)).click();
    // browser.get('https://www.google.com/')
  })
});