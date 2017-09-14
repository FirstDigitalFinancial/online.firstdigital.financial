import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PingComponent }        from './ping.component';
import { HomepageComponent }    from './homepage.component';
import { AboutComponent }       from './about.component';
import { ServicesComponent }    from './services.component';

const routes: Routes = [
  { path: '', redirectTo: '/homepage', pathMatch: 'full' },
  { path: 'homepage',  component: HomepageComponent },
  { path: 'about',  component: AboutComponent },
  { path: 'services',  component: ServicesComponent },
  { path: 'ping',     component: PingComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
