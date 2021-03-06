import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BookingInquiryComponent } from './booking-inquiry/booking-inquiry.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BookingInquiryComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
