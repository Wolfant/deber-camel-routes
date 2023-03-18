import { NestFactory } from '@nestjs/core';
import { FacturaModule } from './factura/factura.module';

async function bootstrap() {
  const app = await NestFactory.create(FacturaModule);
  await app.listen(3000);
}
bootstrap();
