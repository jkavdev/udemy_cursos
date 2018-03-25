import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { NewComponentComponent } from './new-component/new-component.component';
import { InlineComponentComponent } from './inline-component/inline-component.component';
import { BindingComponentComponent } from './binding-component/binding-component.component';
import { EventComponentComponent } from './event-component/event-component.component';
import { CssInlineComponentComponent } from './css-inline-component/css-inline-component.component';


@NgModule({
  declarations: [
    AppComponent,
    NewComponentComponent,
    InlineComponentComponent,
    BindingComponentComponent,
    EventComponentComponent,
    CssInlineComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
