import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { TestPageComponent } from './test-page/test-page.component';
import { RouterModule, Routes} from '@angular/router';

const appRoutes:Routes=[
  {path: 'Home', component: HomePageComponent},
  {path: 'Tests',component:TestPageComponent},
  {path: '', redirectTo:'/home',pathMatch: 'full' },
  {path: '**', redirectTo:'/home',pathMatch: 'full' }
]

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    TestPageComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
