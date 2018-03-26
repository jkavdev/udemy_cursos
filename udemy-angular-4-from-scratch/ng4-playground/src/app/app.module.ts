import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { AppComponent } from './app.component';
import { NewComponentComponent } from './new-component/new-component.component';
import { InlineComponentComponent } from './inline-component/inline-component.component';
import { BindingComponentComponent } from './binding-component/binding-component.component';
import { EventComponentComponent } from './event-component/event-component.component';
import { CssInlineComponentComponent } from './css-inline-component/css-inline-component.component';
import { DataService } from './data.service';
import { ServiceComponentComponent } from './service-component/service-component.component';
import { AnimationComponentComponent } from './animation-component/animation-component.component';


@NgModule({
  declarations: [
    AppComponent,
    NewComponentComponent,
    InlineComponentComponent,
    BindingComponentComponent,
    EventComponentComponent,
    CssInlineComponentComponent,
    ServiceComponentComponent,
    AnimationComponentComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule
  ],
  providers: [
    DataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
